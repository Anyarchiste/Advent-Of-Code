<#Creates 25 folders named "dayXX" where XX = 01->25
WARNING --> Make sure you change the $year variable to the right year
#>

# Days to christmass
$A = 25

# Year you do the AOC
$year = 2024

$yearPath = "./" + $year

New-Item -ItemType Directory -Path $yearPath

for ($i = 1; $i -lt ($A + 1); $i++) {
    $path = ""
    if ($i -lt 10) {
        $path = ($yearPath + "/day0" + $i)
    } elseif ($i -ge 10) {
        $path = ($yearPath + "/day" + $i)
    }

    New-Item -ItemType Directory -Path $path
}
