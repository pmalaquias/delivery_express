import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart' show AppLocalizations;
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
          child: Text(AppLocalizations.of(context)!.loginButton.toUpperCase()),
          //color: Colors.red,
        );
      },
    );
  }
}
