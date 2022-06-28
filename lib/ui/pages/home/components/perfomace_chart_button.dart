import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart' show AppLocalizations;
import '../../pages.dart';

class PerfomaceChartButton extends StatefulWidget {
  const PerfomaceChartButton({Key? key}) : super(key: key);

  @override
  State<PerfomaceChartButton> createState() => _PerfomaceChartButtonState();
}

class _PerfomaceChartButtonState extends State<PerfomaceChartButton> {
  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: MediaQuery.of(context).size.width,
      child: ElevatedButton.icon(
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => const PerfomaceChartPage(),
            ),
          );
        },
        icon: const Icon(Icons.bar_chart_rounded),
        label: Text(
          AppLocalizations.of(context)!.perfomaceChartButton.toUpperCase(),
          textAlign: TextAlign.center,
        ),
      ),
    );
  }
}
