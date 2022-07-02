import 'package:flutter/material.dart';

import '../../../extension/extension.dart';
import '../../../theme/theme.dart';
import '../login.dart' show LoginPresenter;

class RadioButtonCustom extends StatefulWidget {
  final LoginPresenter presenter;

  const RadioButtonCustom({Key? key, required this.presenter}) : super(key: key);

  @override
  State<RadioButtonCustom> createState() => _RadioButtonCustomState();
}

class _RadioButtonCustomState extends State<RadioButtonCustom> {
  int value = 1;

  Widget customRadioButton(String title, String text, int index) {
    return StreamBuilder<Object>(
        stream: widget.presenter.signUpTypeStream,
        builder: (context, snapshot) {
          return InkWell(
            onTap: () {
              setState(() {
                value = index;
                widget.presenter.selectTypeSignUp(value);
              });
            },
            child: Card(
              shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
              elevation: (value == index) ? 4 : 0,
              color: (value == index) ? AppColors.primaryRed : Colors.white.withAlpha(200),
              child: SizedBox(
                width: double.infinity,
                height: 70,
                child: Column(
                  children: [
                    Text(
                      title,
                      style: TextStyle(
                        color: (value == index) ? Colors.white : Colors.black,
                        fontWeight: FontWeight.bold,
                      ),
                      textAlign: TextAlign.center,
                    ),
                    const SizedBox(height: 8),
                    Text(
                      text,
                      style: TextStyle(
                        color: (value == index) ? Colors.white : Colors.black,
                      ),
                      textAlign: TextAlign.center,
                    ),
                  ],
                ),
              ),
            ),
          );
        });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: <Widget>[
        customRadioButton(
          context.loc.deleverymanLabel,
          context.loc.deliverymanText,
          1,
        ),
        customRadioButton(
          context.loc.clientLabel,
          context.loc.clientText,
          2,
        ),
      ],
    );
  }
}
