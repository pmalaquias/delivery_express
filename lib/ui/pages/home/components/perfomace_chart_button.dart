import 'package:flutter/material.dart';

import '../../../extension/extension.dart';
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
          context.loc.performanceChartButton.toUpperCase(),
          textAlign: TextAlign.center,
        ),
      ),
    );
  }
}
