import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart' show AppLocalizations;
import '../../../../validation/validators/validator.dart' show Validator;
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
            hintText: AppLocalizations.of(context)!.email,
            label: Text(AppLocalizations.of(context)!.email),
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
