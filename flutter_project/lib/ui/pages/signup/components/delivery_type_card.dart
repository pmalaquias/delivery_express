import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class DeliveryTypeCard extends StatelessWidget {
  final String image;
  final String label;
  final double? widthImg;

  const DeliveryTypeCard({
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
            SvgPicture.asset(image, width: widthImg),
            Text(label),
          ],
        ),
      ),
    );
  }
}
