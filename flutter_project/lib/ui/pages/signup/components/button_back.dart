import 'package:flutter/material.dart';

import '../../../extension/extension.dart';

class ButtonBack extends StatelessWidget {
  final Function function;

  const ButtonBack({
    Key? key,
    required this.function,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextButton(
      onPressed: () => function(),
      child: Text(context.loc.backButton.toUpperCase()),
    );
  }
}
