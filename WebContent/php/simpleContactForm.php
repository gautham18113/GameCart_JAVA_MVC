<?php

$emailRecipient = 'addyouremail@yahoo.com';	// Enter recipient Email Here



function splitDataForm($encodedData) {

	$datas = explode('||', $encodedData);

	return $datas;

}

$emailContent;

$emailSubject = $_POST['emailSubject'];

$emailSender = $_POST['emailSender'];



foreach ($_POST as $key => $data) {

	$datas = splitDataForm($data);

	$label = $datas[0];

	$value = $datas[1];

	if (count($value) > 0) {

		$emailContent .= '<p><strong>' . $label . '</strong> ' . stripslashes(nl2br($value)) . '</p>';

	}



}

$emailHeader = "Return-Path: " . $emailSender . "\n";

$emailHeader .= "From:" . $emailSender . "\n";

$emailHeader .= "X-Mailer: PHP " . phpversion() . "\n";

$emailHeader .= "Reply-To: " . $emailSender . "\n";

$emailHeader .= "X-Priority: 3 (Normal)\n";

$emailHeader .= "Mime-Version: 1.0\n";

$emailHeader .= "Content-type: text/html; charset=utf-8\n";



mail($emailRecipient, $emailSubject, $emailContent, $emailHeader) or die('error');

?>