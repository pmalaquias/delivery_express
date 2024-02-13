import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../../extension/extension.dart';

class PerformanceChartButton extends StatefulWidget {
  const PerformanceChartButton({Key? key}) : super(key: key);

  @override
  State<PerformanceChartButton> createState() => _PerformanceChartButtonState();
}

class _PerformanceChartButtonState extends State<PerformanceChartButton> {
  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: MediaQuery.of(context).size.width,
      child: ElevatedButton.icon(
        onPressed: () {
          Get.toNamed('/performance_chart');
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
