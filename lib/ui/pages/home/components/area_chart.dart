import 'package:flutter/material.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

import '../../../mocks/mocks.dart' show seriesMock;

class AreaChart extends StatelessWidget {
  const AreaChart({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return SfCartesianChart(
      title: ChartTitle(
        text: 'Resumo da Semana',
        alignment: ChartAlignment.near,
      ),

      primaryXAxis: CategoryAxis(
        labelPlacement: LabelPlacement.onTicks,
        majorGridLines: const MajorGridLines(width: 0),
      ), // Initialize category axis.
      tooltipBehavior: TooltipBehavior(
        enable: true,
        header: '',
      ),
      series: seriesMock,
    );
  }
}
