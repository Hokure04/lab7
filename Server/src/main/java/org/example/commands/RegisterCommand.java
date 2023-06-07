package org.example.commands;

import org.example.common.requests.BaseRequest;
import org.example.common.requests.CommandRequest;
import org.example.common.requests.TypesRequest;
import org.example.common.responses.BaseResponse;
import org.example.util.TypeAccess;

public class RegisterCommand extends Command{

    public RegisterCommand(Realization realization){
        super("register", "", "Регистрация нового пользователя", 0, new String[]{}, new String[]{"LOGIN", "PASSWORD"}, TypesRequest.REGISTER, TypeAccess.NOTAUTHORISED, realization);
    }

    @Override
    public BaseResponse execute(BaseRequest request) {
        BaseResponse response = this.getRealization().register(request);
        return response;
    }
}
