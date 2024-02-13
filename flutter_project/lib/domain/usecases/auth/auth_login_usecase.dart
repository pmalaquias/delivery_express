import 'package:equatable/equatable.dart';

import '../../entities/entities.dart' show AccountEntity;

abstract class AuthLoginUseCase {
  Future<AccountEntity> call({required final AuthLoginUseCaseParams params});
}

class AuthLoginUseCaseParams extends Equatable {
  final String email;
  final String password;

  const AuthLoginUseCaseParams({
    required this.email,
    required this.password,
  });

  @override
  List get props => [email, password];
}
