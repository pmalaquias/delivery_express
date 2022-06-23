import 'package:flutter/material.dart';
import 'package:flutter_colorpicker/flutter_colorpicker.dart';
import 'package:flutter_svg/flutter_svg.dart';

import '../../../../l10n/strings/app_localizations.dart';

class VehicleDataView extends StatefulWidget {
  final PageController controller;
  const VehicleDataView({Key? key, required this.controller}) : super(key: key);

  @override
  State<VehicleDataView> createState() => _VehicleDataViewState();
}

class _VehicleDataViewState extends State<VehicleDataView> {
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
            Text(
              AppLocalizations.of(context)!.vehicleColor,
            ),
          ],
        ),
        TextButton(
          child: Text(AppLocalizations.of(context)!.selectButton),
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
                      child: Text(AppLocalizations.of(context)!.saveButton),
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
    return SingleChildScrollView(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          SizedBox(
            height: MediaQuery.of(context).size.height * 0.8,
            child: Column(
              children: [
                Text(
                  AppLocalizations.of(context)!.vehicleData,
                  style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
                ),
                Text(AppLocalizations.of(context)!.vehicleType),
                Column(
                  children: [
                    Wrap(
                      spacing: 8,
                      //mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        SizedBox(
                          width: 112,
                          height: 95,
                          child: Card(
                            child: Column(
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                SvgPicture.asset(
                                  'lib/ui/assets/images/svg/car.svg',
                                  width: 50,
                                ),
                                Text(AppLocalizations.of(context)!.vehicleCar),
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
                                  'lib/ui/assets/images/svg/pickup_truck.svg',
                                  width: 50,
                                ),
                                Text(AppLocalizations.of(context)!.vehiclePickupTruck),
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
                                  'lib/ui/assets/images/svg/truck.svg',
                                  width: 50,
                                ),
                                Text(AppLocalizations.of(context)!.vehicleTruck),
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
                                  'lib/ui/assets/images/svg/motorcycle.svg',
                                  width: 50,
                                ),
                                Text(AppLocalizations.of(context)!.vehicleMotorcycle),
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
                                  'lib/ui/assets/images/svg/bicycle.svg',
                                  width: 50,
                                ),
                                Text(AppLocalizations.of(context)!.vehicleBicycle),
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
                                  'lib/ui/assets/images/svg/other_vehicle.svg',
                                  width: 50,
                                ),
                                Text(AppLocalizations.of(context)!.vehicleOther),
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
                                  'lib/ui/assets/images/svg/motorcycle.svg',
                                  width: 50,
                                ),
                                Text(AppLocalizations.of(context)!.vehicleMotorcycle),
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
                                  'lib/ui/assets/images/svg/bicycle.svg',
                                  width: 50,
                                ),
                                Text(AppLocalizations.of(context)!.vehicleBicycle),
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
                                  'lib/ui/assets/images/svg/other_vehicle.svg',
                                  width: 50,
                                ),
                                Text(AppLocalizations.of(context)!.vehicleOther),
                              ],
                            ),
                          ),
                        ),
                      ],
                    ), */
                  ],
                ),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: AppLocalizations.of(context)!.vehicleModel,
                    label: Text(AppLocalizations.of(context)!.vehicleModel),
                  ),
                ),
                //TODO: Colocar a cor do veiculo
                const SizedBox(height: 8),
                buildColorPicker(context),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: AppLocalizations.of(context)!.licensePlate,
                    label: Text(AppLocalizations.of(context)!.licensePlate),
                  ),
                ),
              ],
            ),
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
      ),
    );
  }
}
