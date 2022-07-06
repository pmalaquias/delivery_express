import 'package:flutter/material.dart';

import '../../../utils/utils.dart';
import 'components.dart';

enum Card {
  masterCard,
  americanExpress,
  visa,
  hipercard,
  elo,
}

class CustomRadioButton extends StatefulWidget {
  const CustomRadioButton({Key? key}) : super(key: key);

  @override
  State<CustomRadioButton> createState() => _CustomRadioButtonState();
}

class _CustomRadioButtonState extends State<CustomRadioButton> {
  Card? _groupValue;

  ValueChanged<Card?> _valueChangedHandler() {
    return (value) => setState(() => _groupValue = value!);
  }

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        RadioOptionCustom<Card>(
          value: Card.masterCard,
          groupValue: _groupValue,
          onChanged: _valueChangedHandler(),
          label: '1',
          text: Images.mastercardLogoImgSvg,
        ),
        RadioOptionCustom<Card>(
          value: Card.americanExpress,
          groupValue: _groupValue,
          onChanged: _valueChangedHandler(),
          label: '2',
          text: Images.americanExpressLogoImgSvg,
        ),
        RadioOptionCustom<Card>(
          value: Card.visa,
          groupValue: _groupValue,
          onChanged: _valueChangedHandler(),
          label: '3',
          text: Images.visaLogoImgSvg,
          imgSize: 30,
        ),
        RadioOptionCustom<Card>(
          value: Card.hipercard,
          groupValue: _groupValue,
          onChanged: _valueChangedHandler(),
          label: '4',
          text: Images.hipercadLogoSvg,
        ),
        RadioOptionCustom<Card>(
          value: Card.elo,
          groupValue: _groupValue,
          onChanged: _valueChangedHandler(),
          label: '5',
          text: Images.eloLogoImgSvg,
          imgSize: 20,
        ),
      ],
    );
  }
}
