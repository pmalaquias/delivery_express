import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart' show AppLocalizations;

class TotalBalanceTile extends StatelessWidget {
  const TotalBalanceTile({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        const Divider(),
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Text(
              AppLocalizations.of(context)!.totalBalance,
              style: const TextStyle(
                fontWeight: FontWeight.bold,
              ),
            ),
            const Text('R\$ 99,00'),
          ],
        ),
      ],
    );
  }
}
