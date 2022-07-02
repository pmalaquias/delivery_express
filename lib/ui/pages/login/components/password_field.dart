import 'package:flutter/material.dart';

import '../../../../validation/validators/validator.dart' show Validator;
import '../../../extension/extension.dart';
import '../../../helpers/helpes.dart';
import '../../../theme/theme.dart' show AppColors;
import '../login.dart' show LoginPresenter;

class PasswordField extends StatefulWidget {
  final LoginPresenter presenter;
  final TextEditingController _passwordTextController;

  const PasswordField({
    Key? key,
    required this.presenter,
    required TextEditingController passwordTextController,
  })  : _passwordTextController = passwordTextController,
        super(key: key);

  @override
  State<PasswordField> createState() => _PasswordFieldState();
}

class _PasswordFieldState extends State<PasswordField> {
  IconData visibilityIcon = Icons.visibility;
  bool visibilityPassword = true;

  @override
  Widget build(BuildContext context) {
    return StreamBuilder<UIError>(
        stream: widget.presenter.passwordErrorStream,
        builder: (context, snapshot) {
          return TextFormField(
            controller: widget._passwordTextController,
            decoration: InputDecoration(
              hintText: context.loc.password,
              label: Text(context.loc.password),
              errorText: snapshot.hasData && snapshot.data != UIError.NO_ERROR ? snapshot.data?.desscription : null,
              suffixIcon: IconButton(
                focusColor: AppColors.primaryRed,
                icon: Icon(visibilityIcon),
                onPressed: () {
                  setState(() {
                    if (visibilityPassword == true) {
                      visibilityPassword = false;
                      visibilityIcon = Icons.visibility_off;
                    } else {
                      visibilityPassword = true;
                      visibilityIcon = Icons.visibility;
                    }
                  });
                },
              ),
            ),
            obscureText: visibilityPassword,
            validator: (value) => Validator.validatePassword(password: value!),
            onChanged: widget.presenter.validatePassword,
          );
        });
  }
}
