x1 = ?  ;  y1 = ? ;    // First diagonal point
x2 = ?  ;  y2 = ? ;    // Second diagonal point

xc = (x1 + x2)/2  ;  yc = (y1 + y2)/2  ;    // Center point
xd = (x1 - x2)/2  ;  yd = (y1 - y2)/2  ;    // Half-diagonal

x3 = xc - yd  ;  y3 = yc + xd;    // Third corner
x4 = xc + yd  ;  y4 = yc - xd;    // Fourth corner

// Line equation passing (x1, y1) and (x2, y2)
(y2 - y1) * x + (x1 - x2) * y = x1 * y2 - x2 * y1

