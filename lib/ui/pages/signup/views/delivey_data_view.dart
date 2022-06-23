import 'package:flutter/material.dart';
import 'package:flutter_colorpicker/flutter_colorpicker.dart';
import 'package:flutter_svg/flutter_svg.dart';

import '../../../../l10n/strings/app_localizations.dart';

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
              AppLocalizations.of(context)!.deliveryData,
              style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
            ),
            Text(AppLocalizations.of(context)!.deliveryType),
            Column(
              children: [
                Wrap(
                  //mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    SizedBox(
                      width: 112,
                      height: 95,
                      child: Card(
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            SvgPicture.asset('lib/ui/assets/images/svg/food.svg'),
                            Text(AppLocalizations.of(context)!.deliveryFood),
                          ],
                        ),
                      ),
                    ),
                    SizedBox(
                      width: 112,
                      height: 95,
                      child: Card(
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            SvgPicture.asset('lib/ui/assets/images/svg/clothing.svg'),
                            Text(AppLocalizations.of(context)!.deliveryClothing),
                          ],
                        ),
                      ),
                    ),
                    SizedBox(
                      width: 112,
                      height: 95,
                      child: Card(
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            SvgPicture.asset('lib/ui/assets/images/svg/documents.svg'),
                            Text(AppLocalizations.of(context)!.deliveryDocuments),
                          ],
                        ),
                      ),
                    ),
                    SizedBox(
                      width: 112,
                      height: 95,
                      child: Card(
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            SvgPicture.asset(
                              'lib/ui/assets/images/svg/fragile_order.svg',
                              width: 45,
                            ),
                            Flexible(
                              child: Text(
                                AppLocalizations.of(context)!.deliveryFragileOrder,
                                textAlign: TextAlign.center,
                              ),
                            ),
                          ],
                        ),
                      ),
                    ),
                    SizedBox(
                      width: 112,
                      height: 95,
                      child: Card(
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            SvgPicture.asset(
                              'lib/ui/assets/images/svg/heavy_order.svg',
                              width: 45,
                            ),
                            Text(
                              AppLocalizations.of(context)!.deliveryHeavyOrder,
                              textAlign: TextAlign.center,
                            ),
                          ],
                        ),
                      ),
                    ),
                    SizedBox(
                      width: 112,
                      height: 95,
                      child: Card(
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            SvgPicture.asset('lib/ui/assets/images/svg/other_delivery.svg'),
                            Text(AppLocalizations.of(context)!.deliveryOther),
                          ],
                        ),
                      ),
                    ),
                  ],
                ),
                /* Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    SizedBox(
                      width: 112,
                      height: 95,
                      child: Card(
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            SvgPicture.asset(
                              'lib/ui/assets/images/svg/fragile_order.svg',
                              width: 45,
                            ),
                            Flexible(
                              child: Text(
                                AppLocalizations.of(context)!.deliveryFragileOrder,
                                textAlign: TextAlign.center,
                              ),
                            ),
                          ],
                        ),
                      ),
                    ),
                    SizedBox(
                      width: 112,
                      height: 95,
                      child: Card(
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            SvgPicture.asset(
                              'lib/ui/assets/images/svg/heavy_order.svg',
                              width: 45,
                            ),
                            Text(
                              AppLocalizations.of(context)!.deliveryHeavyOrder,
                              textAlign: TextAlign.center,
                            ),
                          ],
                        ),
                      ),
                    ),
                    SizedBox(
                      width: 112,
                      height: 95,
                      child: Card(
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            SvgPicture.asset('lib/ui/assets/images/svg/other_delivery.svg'),
                            Text(AppLocalizations.of(context)!.deliveryOther),
                          ],
                        ),
                      ),
                    ),
                  ],
                ), */
                const SizedBox(height: 16),
                Text(
                  AppLocalizations.of(context)!.deliveryDataMessage,
                  textAlign: TextAlign.center,
                ),
              ],
            ),
          ],
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            TextButton(
              onPressed: () {
                setState(() {
                  widget.controller.previousPage(
                    duration: const Duration(milliseconds: 400),
                    curve: Curves.easeIn,
                  );
                });
              },
              child: Text(AppLocalizations.of(context)!.backButton.toUpperCase()),
            ),
            ElevatedButton(
              onPressed: () {
                setState(() {
                  widget.controller.nextPage(
                    duration: const Duration(milliseconds: 400),
                    curve: Curves.easeIn,
                  );
                });
              },
              child: Text(AppLocalizations.of(context)!.continueButton.toUpperCase()),
            ),
          ],
        ),
      ],
    );
  }
}
