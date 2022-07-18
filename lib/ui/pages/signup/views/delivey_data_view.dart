import 'package:flutter/material.dart';
import 'package:flutter_colorpicker/flutter_colorpicker.dart';

import '../../../extension/extension.dart';
import '../../../utils/utils.dart' show Images;
import '../components/components.dart';

enum DeliveryType {
  food,
  clothing,
  documents,
  fragileOrder,
  heavyOrder,
  other,
}

class DeliveryDataView extends StatefulWidget {
  final PageController controller;
  const DeliveryDataView({Key? key, required this.controller}) : super(key: key);

  @override
  State<DeliveryDataView> createState() => _DeliveryDataViewState();
}

class _DeliveryDataViewState extends State<DeliveryDataView> {
  // create some values
  Color pickerColor = const Color(0xff443a49);

  Color _currentColor = const Color(0xff443a49);

// ValueChanged<Color> callback
  void changeColor(Color color) {
    setState(() => pickerColor = color);
  }

  DeliveryType? _groupValue;

  ValueChanged<DeliveryType?> _valueChangedHandler() {
    return (value) => setState(() => _groupValue = value!);
  }

  Widget buildColorPicker(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Row(
          children: [
            Container(
              height: 50,
              width: 10,
              color: _currentColor,
            ),
            const SizedBox(width: 8),
            const Text(
              'Color',
            ),
          ],
        ),
        TextButton(
          child: const Text('Select'),
          onPressed: () {
            showDialog(
              context: context,
              builder: (context) {
                return AlertDialog(
                  content: BlockPicker(
                    useInShowDialog: true,
                    pickerColor: Colors.white,
                    onColorChanged: (color) {
                      setState(() => _currentColor = color);
                    },
                  ),
                  actions: [
                    TextButton(
                      child: const Text('Save'),
                      onPressed: () {
                        Navigator.of(context).pop();
                      },
                    ),
                  ],
                );
              },
            );
          },
        ),
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Column(
          children: [
            Text(
              context.loc.deliveryData,
              style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
            ),
            Text(context.loc.deliveryType),
            Column(
              children: [
                Row(
                  children: [
                    Wrap(
                      children: [
                        RadioOptionTypeCustom<DeliveryType>(
                          value: DeliveryType.food,
                          groupValue: _groupValue,
                          onChanged: _valueChangedHandler(),
                          label: context.loc.deliveryFood,
                          text: Images.foodImgSvg,
                        ),
                        RadioOptionTypeCustom<DeliveryType>(
                          value: DeliveryType.clothing,
                          groupValue: _groupValue,
                          onChanged: _valueChangedHandler(),
                          label: context.loc.deliveryClothing,
                          text: Images.clothingImgSvg,
                        ),
                        RadioOptionTypeCustom<DeliveryType>(
                          value: DeliveryType.documents,
                          groupValue: _groupValue,
                          onChanged: _valueChangedHandler(),
                          label: context.loc.deliveryDocuments,
                          text: Images.documentsImgSvg,
                        ),
                      ],
                    ),
                  ],
                ),
                Row(
                  children: [
                    Wrap(
                      children: [
                        RadioOptionTypeCustom<DeliveryType>(
                          value: DeliveryType.fragileOrder,
                          groupValue: _groupValue,
                          onChanged: _valueChangedHandler(),
                          label: context.loc.deliveryFragileOrder,
                          text: Images.fragileOrderImgSvg,
                        ),
                        RadioOptionTypeCustom<DeliveryType>(
                          value: DeliveryType.heavyOrder,
                          groupValue: _groupValue,
                          onChanged: _valueChangedHandler(),
                          label: context.loc.deliveryHeavyOrder,
                          text: Images.heavyOrderImgSvg,
                        ),
                        RadioOptionTypeCustom<DeliveryType>(
                          value: DeliveryType.other,
                          groupValue: _groupValue,
                          onChanged: _valueChangedHandler(),
                          label: context.loc.deliveryOther,
                          text: Images.otherOrderImgSvg,
                        ),
                      ],
                    ),
                  ],
                ),

                const SizedBox(height: 16),
                Text(
                  context.loc.deliveryDataMessage,
                  textAlign: TextAlign.center,
                ),
              ],
            ),
          ],
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            ButtonBack(function: pageControllerBack),
            ButtonContinue(function: pageControllerContinue),
          ],
        ),
      ],
    );
  }

  void pageControllerBack() {
    widget.controller.previousPage(
      duration: const Duration(milliseconds: 400),
      curve: Curves.easeIn,
    );
  }

  void pageControllerContinue() {
    widget.controller.nextPage(
      duration: const Duration(milliseconds: 400),
      curve: Curves.easeIn,
    );
  }
}
