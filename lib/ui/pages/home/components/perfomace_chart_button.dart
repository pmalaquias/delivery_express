import 'package:flutter/material.dart';

class PerfomaceChartButton extends StatefulWidget {
  const PerfomaceChartButton({Key? key}) : super(key: key);

  @override
  State<PerfomaceChartButton> createState() => _PerfomaceChartButtonState();
}

class _PerfomaceChartButtonState extends State<PerfomaceChartButton> {
  @override
  Widget build(BuildContext context) {
    return ElevatedButton.icon(
      onPressed: () {},
      icon: const Icon(Icons.bar_chart_rounded),
      label: Text(
        'Gráficos de Desempenho'.toUpperCase(),
        textAlign: TextAlign.center,
      ),
    );
  }
}
