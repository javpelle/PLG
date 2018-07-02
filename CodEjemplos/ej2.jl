main {
	decVar: {
		int[10][5] a;
		int i;
		int j;
	}
	i = 0;
	while (i < 10) {
		j = 0;
		while(j < 5) {
			a[i][j] = 0;
			j = j + 1;
		}
		i = i + 1;
	}
}