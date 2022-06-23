import 'package:syncfusion_flutter_charts/charts.dart';

import '../../data/models/home/home.dart';
import '../theme/theme.dart';

List<SalesData> dataMock = [
  SalesData('Dom', 20),
  SalesData('Seg', 10),
  SalesData('Ter', 30),
  SalesData('Qua', 10),
  SalesData('Qui', 5),
  SalesData('Sex', 25),
  SalesData('Sab', 25),
];

List<AreaSeries<SalesData, String>> seriesMock = <AreaSeries<SalesData, String>>[
  // Initialize line series.
  AreaSeries<SalesData, String>(
      color: AppColors.primaryRed.withOpacity(0.6),
      dataSource: dataMock,
      xValueMapper: (SalesData sales, _) => sales.month,
      yValueMapper: (SalesData sales, _) => sales.sales)
];
