import 'package:flutter/material.dart';

import '../../../theme/theme.dart' show AppColors;

class Header extends StatefulWidget {
  const Header({Key? key}) : super(key: key);

  @override
  State<Header> createState() => _HeaderState();
}

class _HeaderState extends State<Header> {
  String dropdownValue = 'DISPONÍVEL';

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: const [
            Text('Boa tarde,'),
            Text(
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
            const Text('Status'),
            DropdownButton<String>(
              value: dropdownValue,
              elevation: 16,
              onChanged: (String? newValue) {
                setState(() {
                  dropdownValue = newValue!;
                });
              },
              items: <String>['DISPONÍVEL', 'INDISPONÍVEL', 'OCUPADO'].map<DropdownMenuItem<String>>((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: value == 'DISPONÍVEL'
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
