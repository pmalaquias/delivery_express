import 'package:flutter/material.dart';

import '../../../../validation/validators/validator.dart' show Validator;
import '../../../extension/extension.dart';
import '../../../helpers/helpes.dart';
import '../login.dart' show LoginPresenter;

class EmailField extends StatelessWidget {
  const EmailField({
    Key? key,
    required this.presenter,
    required TextEditingController emailTextController,
  })  : _emailTextController = emailTextController,
        super(key: key);

  final LoginPresenter presenter;
  final TextEditingController _emailTextController;

  @override
  Widget build(BuildContext context) {
    return StreamBuilder<UIError>(
      stream: presenter.emailErrorStream,
      builder: (context, snapshot) {
        return TextFormField(
          controller: _emailTextController,
          decoration: InputDecoration(
            hintText: context.loc.email,
            label: Text(context.loc.email),
            errorText: snapshot.hasData && snapshot.data != UIError.NO_ERROR ? snapshot.data?.desscription : null,
          ),
          keyboardType: TextInputType.emailAddress,
          validator: (String? value) => Validator.validateEmail(email: value!),
          onChanged: presenter.validateEmail,
        );
      },
    );
  }
}
