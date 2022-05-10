package validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import dtos.RegistrationDto;
import services.UserService;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationDto.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        RegistrationDto registrationDto = (RegistrationDto) obj;
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName", "Не указано Имя");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName", "Не указано Фамилия");
        ValidationUtils.rejectIfEmpty(errors, "nickname", "nickname", "Не указан Логин");
        ValidationUtils.rejectIfEmpty(errors, "password", "password", "Не указан Пароль");
        ValidationUtils.rejectIfEmpty(errors, "consent", "consent", "Не указано Согласие");

        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        if (!(pattern.matcher(registrationDto.getNickname()).matches())) {
            errors.reject("nickname", "Неправильный nickname");
        }

        if (!userService.emailDoesntExist(registrationDto.getNickname())) {
            errors.reject("nickname", "Пользователь с таким логином существует");
        }

        if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            errors.reject("confirmPassword", "Пароли не совпадают");
        }
    }
}
