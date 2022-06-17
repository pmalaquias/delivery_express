import 'package:dropdown_button2/dropdown_button2.dart';
import 'package:flutter/material.dart';

import '../../../../api/estados.dart';

class AddressDataView extends StatefulWidget {
  final PageController controller;
  const AddressDataView({Key? key, required this.controller}) : super(key: key);

  @override
  State<AddressDataView> createState() => _AddressDataViewState();
}

class _AddressDataViewState extends State<AddressDataView> {
  int _currentSliderValue = 0;
  String? dropdownCityValue;
  String? dropdownStateValue;

  Widget buildStateOption() {
    return DropdownButtonHideUnderline(
      child: DropdownButton2(
        hint: Text(
          'UF',
          style: TextStyle(
            fontSize: 14,
            color: Theme.of(context).hintColor,
          ),
        ),
        items: estados
            .map((item) => DropdownMenuItem<String>(
                  value: item['nome'],
                  child: Text(
                    item['nome'],
                    style: const TextStyle(
                      fontSize: 14,
                    ),
                  ),
                ))
            .toList(),
        value: dropdownStateValue,
        onChanged: (value) {
          setState(() {
            dropdownStateValue = value as String;
          });
        },
        buttonHeight: 40,
        buttonWidth: 140,
        itemHeight: 40,
      ),
    );
  }

  Widget buildCityOption() {
    return DropdownButtonHideUnderline(
      child: DropdownButton2(
        hint: Text(
          'Select Item',
          style: TextStyle(
            fontSize: 14,
            color: Theme.of(context).hintColor,
          ),
        ),
        items: estados
            .map((item) => DropdownMenuItem<String>(
                  value: item['nome'],
                  child: Text(
                    item['nome'],
                    style: const TextStyle(
                      fontSize: 14,
                    ),
                  ),
                ))
            .toList(),
        onChanged: (value) {
          setState(() {
            dropdownCityValue = value as String;
          });
        },
        buttonHeight: 40,
        buttonWidth: 140,
        itemHeight: 40,
      ),
    );
  }

  Widget buildDistanceOnTheMap() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Row(
          children: [
            const Text(
              'Distância máxima de exbição no mapa',
            ),
            const SizedBox(width: 16),
            Text(
              '${_currentSliderValue.toInt().toString()} km',
            ),
          ],
        ),
        Slider(
          min: 0.0,
          max: 100.0,
          divisions: 100,
          label: _currentSliderValue.toInt().toString(),
          value: _currentSliderValue.toDouble(),
          onChanged: (double value) {
            setState(() {
              _currentSliderValue = value.toInt();
            });
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
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text(
              'Dados de Endereço',
              style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),
            TextFormField(
              decoration: const InputDecoration(
                hintText: 'Endereço Residencial',
                label: Text('Endereço Residencial'),
              ),
              keyboardType: TextInputType.streetAddress,
            ),
            const SizedBox(height: 8),
            TextFormField(
              decoration: const InputDecoration(
                hintText: 'Número',
                label: Text('Número'),
              ),
              keyboardType: TextInputType.number,
            ),
            const SizedBox(height: 8),
            TextFormField(
              decoration: const InputDecoration(
                hintText: 'Bairro',
                label: Text('Bairro'),
              ),
              keyboardType: TextInputType.none,
            ),
            const SizedBox(height: 8),
            TextFormField(
              decoration: const InputDecoration(
                hintText: 'Complemento',
                label: Text('Complemento'),
              ),
              keyboardType: TextInputType.none,
            ),
            buildStateOption(),
            const SizedBox(height: 8),
            //TODO: Biuld City
            const SizedBox(height: 8),
            buildDistanceOnTheMap(),
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
