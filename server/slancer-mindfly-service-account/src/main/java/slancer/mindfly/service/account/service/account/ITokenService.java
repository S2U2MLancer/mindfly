package slancer.mindfly.service.account.service.account;

import org.springframework.stereotype.Service;

@Service
public interface ITokenService<TP> {
    public String create(TP param);
}
