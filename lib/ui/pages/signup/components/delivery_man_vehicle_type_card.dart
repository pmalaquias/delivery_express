import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class DeliveryManVehicleTypeCard extends StatelessWidget {
  final String image;
  final String label;
  final double? widthImg;

  const DeliveryManVehicleTypeCard({
    required this.image,
    required this.label,
    this.widthImg,
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 112,
      height: 95,
      child: Card(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            SvgPicture.asset(
              image,
              width: 50,
            ),
            Text(label),
          ],
        ),
      ),
    );
  }
}
