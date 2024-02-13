import 'package:flutter/material.dart';

import '../../../extension/extension.dart';
import '../login.dart';

class LoginButton extends StatelessWidget {
  const LoginButton({
    Key? key,
    required this.presenter,
  }) : super(key: key);

  final LoginPresenter presenter;

  @override
  Widget build(BuildContext context) {
    return StreamBuilder(
      stream: presenter.isFormValidStream,
      builder: (context, snapshot) {
        return ElevatedButton(
          onPressed: snapshot.data == true ? presenter.auth : null,
          child: Text(context.loc.loginButton.toUpperCase()),
          //color: Colors.red,
        );
      },
    );
  }
}
