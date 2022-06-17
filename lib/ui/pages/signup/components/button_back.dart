import 'package:flutter/material.dart';

class ButtonBack extends StatelessWidget {
  final PageController controller;

  const ButtonBack({Key? key, required this.controller}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextButton(
      onPressed: () {
        controller.previousPage(
          duration: const Duration(milliseconds: 400),
          curve: Curves.easeIn,
        );
      },
      child: const Text('VOLTAR'),
    );
  }
}
