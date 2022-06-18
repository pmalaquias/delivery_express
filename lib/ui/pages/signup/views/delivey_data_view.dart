import 'package:flutter/material.dart';
import 'package:flutter_colorpicker/flutter_colorpicker.dart';
import 'package:flutter_svg/flutter_svg.dart';

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
              'Dados do Delivery',
              style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
            ),
            const Text('Tipo do Entrga'),
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
                            SvgPicture.asset('lib/ui/assets/images/svg/food.svg'),
                            const Text('Alimentação'),
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
                            const Text('Vestuário'),
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
                            const Text('Documentos'),
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
                              'lib/ui/assets/images/svg/fragile_order.svg',
                              width: 45,
                            ),
                            const Flexible(
                              child: Text(
                                'Encomenda frágio',
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
                            const Text(
                              'Encomenda pessada',
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
                            const Text('Outro'),
                          ],
                        ),
                      ),
                    ),
                  ],
                ),
                const SizedBox(height: 16),
                const Text(
                  'Selecione os principais tipo de entrega que você precisa realizar. Você poderá alterá-las posteriormente nas Configurações do aplicativo.',
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
