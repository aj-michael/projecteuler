<?php
	ini_set('memory_limit', '-1');
	function nth_prime($n) {
		return helper($n-2, 3);
	}
	function helper($n, $start) {
		return odd_prime($start) ?
					$n ?
						helper($n-1, $start+2, $start) :
						$start :
					helper($n, $start+2);
	}
	function odd_prime($n) {
		for($i=3, $top=sqrt($n); $i <= $top; $i++) {
			if ($n%$i == 0) return FALSE;
		}
		return TRUE;
	}
	echo nth_prime(10001);
?>