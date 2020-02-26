def minion_game(s):
    n = len(s)
    ks = ss = 0
    for i in range(0, n):
        if s[i] in 'AEOUI':
            ks += n - i
        else:
            ss += n - i
    if ks == ss:
        print 'Draw'
    elif ks > ss:
        print 'Kevin %s' % ks
    else:
        print 'Stuart %s' % ss

if __name__ == '__main__':
    s = raw_input()
    minion_game(s)
