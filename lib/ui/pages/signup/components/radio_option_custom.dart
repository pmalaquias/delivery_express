import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class RadioOptionCustom<T> extends StatelessWidget {
  final T value;
  final T? groupValue;
  final String label;
  final String text;
  final ValueChanged<T?> onChanged;
  final double imgSize;

  const RadioOptionCustom({
    required this.value,
    required this.groupValue,
    required this.label,
    required this.text,
    required this.onChanged,
    this.imgSize = 20,
    Key? key,
  }) : super(key: key);

  Widget _buildLabel() {
    final bool isSelected = value == groupValue;

    return SvgPicture.asset(
      text,
      height: isSelected ? 40 : imgSize,
      color: isSelected ? null : const Color.fromARGB(99, 158, 158, 158),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.all(8),
      child: InkWell(
        onTap: () => onChanged(value),
        splashColor: Theme.of(context).primaryColor.withOpacity(0.1),
        child: Padding(
          padding: const EdgeInsets.all(5),
          child: Row(
            children: [
              _buildLabel(),
            ],
          ),
        ),
      ),
    );
  }
}
