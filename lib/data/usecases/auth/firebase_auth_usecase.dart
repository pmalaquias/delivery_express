import 'package:firebase_auth/firebase_auth.dart';

import '../../../domain/usecases/auth/auth.dart' show FireAuthUseCase, FireAuthUseCaseParams;

class FirebaseAuthUsecase implements FireAuthUseCase {
  @override
  Future<User?> call({required FireAuthUseCaseParams params}) async {
    FirebaseAuth auth = FirebaseAuth.instance;
    User? user;

    try {
      UserCredential userCredential = await auth.signInWithEmailAndPassword(
        email: params.email,
        password: params.password,
      );

      user = userCredential.user;
    } on FirebaseException catch (e) {
      if (e.code == 'user-not-found') {
        print('No user found for that email.');
      } else if (e.code == 'wrong-password') {
        print('Wrong password provided.');
      }
    }

    return user;
  }
}
