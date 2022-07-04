import 'package:flutter/material.dart';

import '../../../extension/extension.dart';

class ForgotPasswordButton extends StatelessWidget {
  const ForgotPasswordButton({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.end,
      children: [
        Text(context.loc.forgotPasswordMessage),
        TextButton(
          onPressed: () {},
          child: Text(context.loc.forgotPasswordButton),
        ),
      ],
    );
  }
}
