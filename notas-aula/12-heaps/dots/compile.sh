filename=$1
size=$2
dot -Tps2 dots/${filename}.dot -o dots/${filename}.eps;
echo \\includegraphics\[width=$size\\linewidth\]\{dots/${filename}}
