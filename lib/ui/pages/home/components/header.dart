import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart' show AppLocalizations;
import '../../../theme/theme.dart' show AppColors;

class Header extends StatefulWidget {
  const Header({Key? key}) : super(key: key);

  @override
  State<Header> createState() => _HeaderState();
}

class _HeaderState extends State<Header> {
  @override
  Widget build(BuildContext context) {
    String dropdownValue = AppLocalizations.of(context)!.status_available;
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(AppLocalizations.of(context)!.goodAfternoon),
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
              items: <String>[
                AppLocalizations.of(context)!.status_available,
                AppLocalizations.of(context)!.status_unavailable,
                AppLocalizations.of(context)!.status_busy
              ].map<DropdownMenuItem<String>>((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: value == AppLocalizations.of(context)!.status_available
                      ? Text(
                          value,
                          style: const TextStyle(
                            color: AppColors.success,
                            fontWeight: FontWeight.w500,
                          ),
                        )
                      : Text(value),
                );
              }).toList(),
            ),
            //const Text('DISPONÍVEL'),
          ],
        ),
      ],
    );
  }
}
