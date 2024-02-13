import 'package:flutter/material.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

import '../../../extension/extension.dart';
import '../../../mocks/mocks.dart' show seriesAreaMock;

class AreaChart extends StatelessWidget {
  const AreaChart({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return SfCartesianChart(
      title: ChartTitle(
        text: context.loc.weekSummary,
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
      series: seriesAreaMock,
    );
  }
}
