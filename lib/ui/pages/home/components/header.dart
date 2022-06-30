import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart' show AppLocalizations;
import '../../../theme/theme.dart' show AppColors;
import 'components.dart' show HourOfDay;

class Header extends StatefulWidget {
  const Header({Key? key}) : super(key: key);

  @override
  State<Header> createState() => _HeaderState();
}

class _HeaderState extends State<Header> {
  String dropdownValue = '1';
  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            HourOfDay(),
            const Text(
              'Maria Aparecida',
              style: TextStyle(
                fontWeight: FontWeight.w500,
                fontSize: 16,
              ),
            ),
          ],
        ),
        Column(
          crossAxisAlignment: CrossAxisAlignment.end,
          children: [
            Text(AppLocalizations.of(context)!.status),
            DropdownButton<String>(
              value: dropdownValue,
              elevation: 16,
              onChanged: (String? newValue) {
                setState(() {
                  dropdownValue = newValue!;
                });
              },
              items: <String>['1', '2', '3'].map<DropdownMenuItem<String>>((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: value == '1'
                      ? Text(
                          AppLocalizations.of(context)!.status_available,
                          style: const TextStyle(
                            color: AppColors.success,
                            fontWeight: FontWeight.w500,
                          ),
                        )
                      : value == '2'
                          ? Text(AppLocalizations.of(context)!.status_unavailable)
                          : Text(AppLocalizations.of(context)!.status_busy),
                );
              }).toList(),
            ),
          ],
        ),
      ],
    );
  }
}
