package slancer.mindfly.core.enumhandler;

import slancer.mindfly.core.errors.CoreErrorCodeEnum;
import slancer.mindfly.core.exception.ExceptionBuilder;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Amos Xia
 * @date 2018/4/18
 */
public class IntEnumParser {

    /**
     *
     * @param value enum int value
     * @param etClass class of Enum Type
     * @param <ET> Enum Type implement IIntEnum
     * @return
     */
    public static <ET extends Enum<ET> & IIntEnum> ET convert(
            int value, Class<ET> etClass) {
        Optional<ET> optional = Stream.of(etClass.getEnumConstants())
                .filter(et -> et.getValue() == value)
                .findAny();
        if (!optional.isPresent()) {
            throw ExceptionBuilder.build(CoreErrorCodeEnum.IntEnumItemNotExisted,
                    String.format("%d not existed in Enum[%s]", value, etClass.getName()));
        }

        return optional.get();
    }
}
