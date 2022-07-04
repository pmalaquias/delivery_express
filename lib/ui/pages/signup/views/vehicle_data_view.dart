import 'package:flutter/material.dart';
import 'package:flutter_colorpicker/flutter_colorpicker.dart';

import '../../../extension/extension.dart';
import '../../../utils/utils.dart';
import '../components/components.dart';

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
              context.loc.vehicleColor,
            ),
          ],
        ),
        TextButton(
          child: Text(context.loc.selectButton),
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
                      child: Text(context.loc.saveButton),
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
                  context.loc.vehicleData,
                  style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
                ),
                Text(context.loc.vehicleType),
                Column(
                  children: [
                    Wrap(
                      spacing: 8,
                      //mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        DeliveryManVehicleTypeCard(
                          image: Images.carImgSvg,
                          label: context.loc.vehicleCar,
                        ),
                        DeliveryManVehicleTypeCard(
                          image: Images.pickupTruckImgSvg,
                          label: context.loc.vehiclePickupTruck,
                        ),
                        DeliveryManVehicleTypeCard(
                          image: Images.truckImgSvg,
                          label: context.loc.vehicleTruck,
                        ),
                        DeliveryManVehicleTypeCard(
                          image: Images.motorcycleImgSvg,
                          label: context.loc.vehicleMotorcycle,
                        ),
                        DeliveryManVehicleTypeCard(
                          image: Images.bicycleImgSvg,
                          label: context.loc.vehicleBicycle,
                        ),
                        DeliveryManVehicleTypeCard(
                          image: Images.otherVehicleImgSvg,
                          label: context.loc.vehicleOther,
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
                //TODO: Colocar a cor do veiculo
                const SizedBox(height: 8),
                buildColorPicker(context),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: context.loc.licensePlate,
                    label: Text(context.loc.licensePlate),
                  ),
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
