import 'package:flex_color_picker/flex_color_picker.dart';
import 'package:flutter/material.dart';

import '../../../extension/extension.dart';
import '../../../mixins/mixins.dart';
import '../../../utils/utils.dart';
import '../components/components.dart';

enum VehicleType {
  car,
  pickupTruck,
  truck,
  motorcycle,
  bicycle,
  other,
}

class VehicleDataView extends StatefulWidget {
  final PageController controller;

  const VehicleDataView({Key? key, required this.controller}) : super(key: key);

  @override
  State<VehicleDataView> createState() => _VehicleDataViewState();
}

class _VehicleDataViewState extends State<VehicleDataView> with InputMask {
  Color screenPickerColor = Colors.red;
  late Color dialogPickerColor;
  Color dialogSelectColor = Colors.red;

  static const Color guidePrimary = Colors.white70;
  static const Color guidePrimaryVariant = Colors.grey;
  static const Color guideSecondary = Colors.black;
  static const Color guideRed = Color(0xFFB00020);
  static const Color blue = Color(0xFF174378);
  static const Color guideSecondaryVariant = Color(0xFF018786);
  static const Color guidePink = Color(0xFFCF6679);

  VehicleType? _groupValue;

  ValueChanged<VehicleType?> _valueChangedHandler() {
    return (value) => setState(() => _groupValue = value!);
  }

  final Map<ColorSwatch<Object>, String> colorsNameMap = <ColorSwatch<Object>, String>{
    ColorTools.createPrimarySwatch(guidePrimary): 'White',
    ColorTools.createPrimarySwatch(guidePrimaryVariant): 'Grey',
    ColorTools.createAccentSwatch(guideSecondary): 'Guide Teal',
    ColorTools.createAccentSwatch(guideSecondaryVariant): 'Guide Teal Variant',
    ColorTools.createPrimarySwatch(guideRed): 'Red',
    ColorTools.createPrimarySwatch(guidePink): 'Pink',
    ColorTools.createPrimarySwatch(blue): 'Blue',
  };

  @override
  void initState() {
    screenPickerColor = Colors.blue;
    dialogPickerColor = Colors.red;
    dialogSelectColor = const Color(0xFFA239CA);
    super.initState();
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
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  context.loc.vehicleData,
                  style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
                  textAlign: TextAlign.center,
                ),
                Text(context.loc.vehicleType),
                Column(
                  children: [
                    Row(
                      children: [
                        Wrap(
                          children: [
                            RadioOptionTypeCustom<VehicleType>(
                              value: VehicleType.car,
                              groupValue: _groupValue,
                              onChanged: _valueChangedHandler(),
                              label: context.loc.vehicleCar,
                              text: Images.carImgSvg,
                            ),
                            RadioOptionTypeCustom<VehicleType>(
                              value: VehicleType.pickupTruck,
                              groupValue: _groupValue,
                              onChanged: _valueChangedHandler(),
                              label: context.loc.vehiclePickupTruck,
                              text: Images.pickupTruckImgSvg,
                            ),
                            RadioOptionTypeCustom<VehicleType>(
                              value: VehicleType.truck,
                              groupValue: _groupValue,
                              onChanged: _valueChangedHandler(),
                              label: context.loc.vehicleTruck,
                              text: Images.truckImgSvg,
                            ),
                          ],
                        ),
                      ],
                    ),
                    Row(
                      children: [
                        Wrap(
                          children: [
                            RadioOptionTypeCustom<VehicleType>(
                              value: VehicleType.motorcycle,
                              groupValue: _groupValue,
                              onChanged: _valueChangedHandler(),
                              label: context.loc.vehicleMotorcycle,
                              text: Images.motorcycleImgSvg,
                            ),
                            RadioOptionTypeCustom<VehicleType>(
                              value: VehicleType.bicycle,
                              groupValue: _groupValue,
                              onChanged: _valueChangedHandler(),
                              label: context.loc.vehicleBicycle,
                              text: Images.bicycleImgSvg,
                            ),
                            RadioOptionTypeCustom<VehicleType>(
                              value: VehicleType.other,
                              groupValue: _groupValue,
                              onChanged: _valueChangedHandler(),
                              label: context.loc.vehicleOther,
                              text: Images.otherVehicleImgSvg,
                            ),
                          ],
                        ),
                      ],
                    ),
                  ],
                ),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: context.loc.vehicleModel,
                    label: Text(context.loc.vehicleModel),
                  ),
                ),
                const SizedBox(height: 16),
                Text(
                  context.loc.vehicleColor,
                  textAlign: TextAlign.start,
                ),
                const SizedBox(height: 8),
                buildColorPicker(context),

                const SizedBox(height: 8),
                // buildColorPicker(context),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: 'ABC1D234 or ABC-1234',
                    label: Text(context.loc.licensePlate),
                  ),
                  inputFormatters: [licensePlateMaskFormatter],
                ),
              ],
            ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              ButtonBack(function: pageControllerBack),
              ButtonContinue(function: pageControllerContinue),
            ],
          ),
        ],
      ),
    );
  }

  Widget buildColorPicker(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        ColorPicker(
          hasBorder: true,
          elevation: 8,
          crossAxisAlignment: CrossAxisAlignment.center,
          padding: EdgeInsets.zero,
          color: screenPickerColor,
          enableShadesSelection: false,
          maxRecentColors: 5,
          customColorSwatchesAndNames: colorsNameMap,
          pickersEnabled: const <ColorPickerType, bool>{
            ColorPickerType.accent: false,
            ColorPickerType.custom: true,
            ColorPickerType.primary: false,
          },
          onColorChanged: (Color color) => setState(() => screenPickerColor = color),
        ),
        const SizedBox(width: 4),
        ColorIndicator(
            hasBorder: true,
            selectedIcon: dialogSelectColor == screenPickerColor ? Icons.check : Icons.add,
            isSelected: true,
            width: 40,
            height: 40,
            color: dialogSelectColor,
            //elevation: 1,
            onSelectFocus: false,
            onSelect: () async {
              final Color newColor = await showColorPickerDialog(
                context,
                dialogSelectColor,
                title: Text(context.loc.vehicleColor, style: Theme.of(context).textTheme.headline6),
                width: 40,
                height: 40,
                borderRadius: 10,
                wheelDiameter: 165,
                pickersEnabled: <ColorPickerType, bool>{
                  ColorPickerType.wheel: true,
                  ColorPickerType.accent: false,
                  ColorPickerType.primary: false,
                },
                copyPasteBehavior: const ColorPickerCopyPasteBehavior(
                  copyButton: false,
                  pasteButton: false,
                  longPressMenu: false,
                ),
                actionButtons: const ColorPickerActionButtons(
                  okButton: true,
                  closeButton: true,
                  dialogActionButtons: true,
                ),
              );

              setState(() {
                dialogSelectColor = newColor;
                screenPickerColor = newColor;
              });
            }),
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
