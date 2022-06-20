import 'package:dropdown_button2/dropdown_button2.dart';
import 'package:flutter/material.dart';

import '../../../../api/estados.dart';
import '../../../../l10n/strings/app_localizations.dart';

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
          AppLocalizations.of(context)!.state,
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
            Text(
              AppLocalizations.of(context)!.maximumDisplayDistance,
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
              AppLocalizations.of(context)!.addressData,
              style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),
            TextFormField(
              decoration: InputDecoration(
                hintText: AppLocalizations.of(context)!.homeAddress,
                label: Text(AppLocalizations.of(context)!.homeAddress),
              ),
              keyboardType: TextInputType.streetAddress,
            ),
            const SizedBox(height: 8),
            TextFormField(
              decoration: InputDecoration(
                hintText: AppLocalizations.of(context)!.number,
                label: Text(AppLocalizations.of(context)!.number),
              ),
              keyboardType: TextInputType.number,
            ),
            const SizedBox(height: 8),
            TextFormField(
              decoration: InputDecoration(
                hintText: AppLocalizations.of(context)!.neighborhood,
                label: Text(AppLocalizations.of(context)!.neighborhood),
              ),
              keyboardType: TextInputType.none,
            ),
            const SizedBox(height: 8),
            TextFormField(
              decoration: InputDecoration(
                hintText: AppLocalizations.of(context)!.complement,
                label: Text(AppLocalizations.of(context)!.complement),
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
