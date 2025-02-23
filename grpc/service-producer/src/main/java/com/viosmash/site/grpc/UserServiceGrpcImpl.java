package com.viosmash.site.grpc;

import com.viosmash.site.userservice.api.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class UserServiceGrpcImpl extends UserServiceGrpc.UserServiceImplBase {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void get(UserGetRequest request, StreamObserver<UserGetResponse> responseObserver) {
        logger.info("[get]");
        UserGetResponse.Builder builder = UserGetResponse.newBuilder();
        builder.setId(request.getId())
                .setName("没有昵称：" + request.getId())
                .setGender(request.getId() % 2 + 1);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void create(UserCreateRequest request, StreamObserver<UserCreateResponse> responseObserver) {
        logger.info("[create]");
        UserCreateResponse.Builder builder = UserCreateResponse.newBuilder();
        builder.setId((int) (System.currentTimeMillis() / 1000));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
