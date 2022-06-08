const fs = require("fs");
const path = require("path");
const MatchcsvFilePath = path.resolve(__dirname, "../data/matches.csv");
const deliveryCsvFilePath = path.resolve(__dirname, "../data/deliveries.csv")
const csv=require('csvtojson')
const ipl = require("./ipl");
const { match } = require("assert");
csv()
.fromFile(MatchcsvFilePath)
.then((matches)=>
{


csv()
.fromFile(deliveryCsvFilePath)
.then((delivery)=>
{
    

    // Number of matches played per year for all the years in IPL.
    console.log("matches played per year");
    let matchesPerYear = ipl.getMatchesPerYear(matches);
    console.log(matchesPerYear);
    

    // Number of matches won per team per year in IPL.
    console.log("no of matches won per year");
    let matchesWonPerYear = ipl.noOfMatchesWonPerYear(matches);
    console.log(matchesWonPerYear);
    

    // Extra runs conceded per team in the year 2016
    console.log("extra run conceded per team in 2016");
    let extraRunsIn2016 = ipl.extraRuns2016(matches,delivery,2016);
    console.log(extraRunsIn2016);

    

    
    // Top 10 economical bowlers in the year 2015
    console.log("top 10 economical bowlers in 2015");
    let topEconomialBowler = ipl.topEconomialBowler(matches,delivery,2015);
    
    ;
    console.log(topEconomialBowler);
    
})
});
