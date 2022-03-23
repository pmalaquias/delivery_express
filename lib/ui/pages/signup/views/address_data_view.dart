import 'package:flutter/material.dart';

class AddressDataView extends StatefulWidget {
  final PageController controller;
  const AddressDataView({Key? key, required this.controller}) : super(key: key);

  @override
  State<AddressDataView> createState() => _AddressDataViewState();
}

class _AddressDataViewState extends State<AddressDataView> {
  int _currentSliderValue = 0;
  String dropdownCityValue = 'Option 1';
  String dropdownStateValue = 'Option 1';

  Widget buildStateOption() {
    return DropdownButton(
      hint: const Text('UF'),
      value: dropdownStateValue,
      items: const [
        DropdownMenuItem(
          value: 'Option 1',
          child: Text('Option 1'),
        ),
        DropdownMenuItem(
          value: 'Option 2',
          child: Text('Option 2'),
        ),
        DropdownMenuItem(
          value: 'Option 3',
          child: Text('Option 3'),
        ),
        DropdownMenuItem(
          value: 'Option 4',
          child: Text('Option 4'),
        ),
        DropdownMenuItem(
          value: 'Option 5',
          child: Text('Option 5'),
        ),
        DropdownMenuItem(
          value: 'Option 6',
          child: Text('Option 6'),
        ),
      ],
      onChanged: (value) {
        setState(() {
          dropdownStateValue = value as String;
        });
      },
    );
  }

  Widget buildCityOption() {
    return DropdownButton(
      hint: const Text('Cidade'),
      value: dropdownCityValue,
      items: const [
        DropdownMenuItem(
          value: 'Option 1',
          child: Text('Option 1'),
        ),
        DropdownMenuItem(
          value: 'Option 2',
          child: Text('Option 2'),
        ),
        DropdownMenuItem(
          value: 'Option 3',
          child: Text('Option 3'),
        ),
        DropdownMenuItem(
          value: 'Option 4',
          child: Text('Option 4'),
        ),
        DropdownMenuItem(
          value: 'Option 5',
          child: Text('Option 5'),
        ),
        DropdownMenuItem(
          value: 'Option 6',
          child: Text('Option 6'),
        ),
      ],
      onChanged: (value) {
        setState(() {
          dropdownCityValue = value as String;
        });
      },
    );
  }

  Widget buildQuantityField() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Row(
          children: [
            const Text(
              'Quantity',
            ),
            const SizedBox(width: 16),
            Text(
              _currentSliderValue.toInt().toString(),
            ),
          ],
        ),
        Slider(
          //inactiveColor: _currentColor.withOpacity(0.5),
          //activeColor: _currentColor,
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
            buildCityOption(),
            buildQuantityField(),
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
