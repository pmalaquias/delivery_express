import 'package:equatable/equatable.dart';
import 'package:firebase_auth/firebase_auth.dart';

abstract class FireAuthUseCase {
  Future<User?> call({required final FireAuthUseCaseParams params});
}

class FireAuthUseCaseParams extends Equatable {
  final String email;
  final String password;

  const FireAuthUseCaseParams({
    required this.email,
    required this.password,
  });

  @override
  List get props => [email, password];
}
