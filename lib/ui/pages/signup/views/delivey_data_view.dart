import 'package:flutter/material.dart';
import 'package:flutter_colorpicker/flutter_colorpicker.dart';

import '../../../extension/extension.dart';
import '../../../utils/utils.dart' show Images;
import '../components/components.dart';

class DeliveyDataView extends StatefulWidget {
  final PageController controller;
  const DeliveyDataView({Key? key, required this.controller}) : super(key: key);

  @override
  State<DeliveyDataView> createState() => _DeliveyDataViewState();
}

class _DeliveyDataViewState extends State<DeliveyDataView> {
  // create some values
  Color pickerColor = const Color(0xff443a49);

  Color _currentColor = const Color(0xff443a49);

// ValueChanged<Color> callback
  void changeColor(Color color) {
    setState(() => pickerColor = color);
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
                Wrap(
                  children: [
                    DeliveryTypeCard(
                      image: Images.foodImgSvg,
                      label: context.loc.deliveryFood,
                    ),
                    DeliveryTypeCard(
                      image: Images.clothingImgSvg,
                      label: context.loc.deliveryClothing,
                    ),
                    DeliveryTypeCard(
                      image: Images.documentsImgSvg,
                      label: context.loc.deliveryDocuments,
                    ),
                    DeliveryTypeCard(
                      image: Images.fragileOrderImgSvg,
                      label: context.loc.deliveryFragileOrder,
                    ),
                    DeliveryTypeCard(
                      image: Images.heavyOrderImgSvg,
                      label: context.loc.deliveryHeavyOrder,
                    ),
                    DeliveryTypeCard(
                      image: Images.otherOrderImgSvg,
                      label: context.loc.deliveryOther,
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
