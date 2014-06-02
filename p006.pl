#!/usr/local/bin/perl
$sum1=0; $sum2=0;
map {$sum1 += $_, $sum2 += $_*$_} (1..100);
print $sum1 * $sum1 - $sum2;