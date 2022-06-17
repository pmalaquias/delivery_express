import 'package:flutter/material.dart';
import 'package:flutter_colorpicker/flutter_colorpicker.dart';
import 'package:flutter_svg/flutter_svg.dart';

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
              'Dados do Veículo',
              style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
            ),
            const Text('Tipo do Veiculo'),
            Column(
              children: [
                Row(
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
                              'lib/ui/assets/images/svg/car.svg',
                              width: 50,
                            ),
                            const Text('Carro'),
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
                            const Text('Caminhoneta'),
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
                            const Text('Caminhão'),
                          ],
                        ),
                      ),
                    ),
                  ],
                ),
                Row(
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
                            const Text('Motocicleta'),
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
                            const Text('Bicicleta'),
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
                            const Text('Outro'),
                          ],
                        ),
                      ),
                    ),
                  ],
                ),
              ],
            ),
            TextFormField(
              decoration: const InputDecoration(
                hintText: 'Modelo',
                label: Text('Modelo'),
              ),
            ),
            //TODO: Colocar a cor do veiculo
            const SizedBox(height: 8),
            buildColorPicker(context),
            TextFormField(
              decoration: const InputDecoration(
                hintText: 'Placa',
                label: Text('Placa'),
              ),
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
              child: const Text('VOLTAR'),
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
              child: const Text('CONTINUAR'),
            ),
          ],
        ),
      ],
    );
  }
}
